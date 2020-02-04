import React from 'react';
import fetch from 'isomorphic-fetch';
import UserList from "./userList";

class UserListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: {}
        }
    }

    componentDidMount() {
        var that = this;
        var request = new Request('http://localhost:8080/user/selectUserByName?name=faith', {
            method: 'GET',
            mode: 'cors',
            headers: {'Content-Type': 'application/json'},

        });
        fetch(request).then(function (res) {
            res.json().then(function (data) {
                that.setState({users: data})
            });
        });
    }

    render() {
        return (
            this.state.users.userId ? <UserList users={this.state.users}/> : "aaaaaaaaaaaaaaaa"
        )
    }
}

export default UserListContainer;