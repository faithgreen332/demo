import React from 'react';
import fetch from 'isomorphic-fetch';
import UserList from "./userList";
import UserDetail from './userDetail';
import PropTypes from 'prop-types';


class UserListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [],
            currentUserId: null
        }
    }

    getChildContext() {
        return {onAddUser: this.handleAddUser}
    }


    componentDidMount() {
        let that = this;
        let request = new Request('http://localhost:8080/user/selectAllUsers', {
            method: 'GET',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'},

        });
        fetch(request).then(function (res) {
            res.json().then(function (data) {
                // that.setState(prevState => ({users: [...prevState.users, data]}))
                that.setState(prevState => ({users: prevState.users.concat(data)}))
            });
        });
    }

    handleAddUser = (user) => {
        let that = this;
        let request = new Request("http://localhost:8080/user/insertUser", {
            method: 'POST',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(user)
        });
        fetch(request);
    };

    handleSetCurrentUser = (userId) => {
        this.setState({currentUserId: userId});
    };

    render() {
        const filterUsers = this.state.users.filter((user) =>
            user.userId === this.state.currentUserId
        );
        const currentUser = filterUsers.length > 0 ? filterUsers[0] : null;
        return (
            <div>
                <UserList users={this.state.users} currentUserId={this.state.currentUserId}
                          onSetCurrentUser={this.handleSetCurrentUser}
                          onAddUser={this.handleAddUser}/>
                < UserDetail
                    currentUser={currentUser}
                />
            </div>
        )
    }


}

UserListContainer.childContextTypes = {
    onAddUser: PropTypes.func
};
export default UserListContainer;