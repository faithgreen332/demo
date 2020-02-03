import React from 'react';
import fetch from 'isomorphic-fetch';
import UserList from "./userList";

class UserListContainer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
    }

    componentDidMount() {
        let that = this;
        let request = new Request('http://localhost:8080/user/selectUserByName?name=faith', {
            method: 'GET',
            mode:'cors',
            headers: {'Content-Type': 'application/json'},

        });
        fetch(request).then(function (res) {
            if (!res.ok) {
                return res.text().then(result => Promise.reject(new Error(result)));
            }
            return res.json();
        }).then(function (data) {
            that.setState({users: data},);
        });
    }

    render() {
        return (
            /* 通过props传递user*/
            <UserList users={this.state.users}/>
        );
    }
}

export default UserListContainer;