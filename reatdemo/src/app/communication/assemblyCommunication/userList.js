import React from 'react';
import UserAdd from './userAdd.js'

export default class UserList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            newUser: {
                userId: "尼古拉斯",
                userName: "伊布拉希莫维奇",
                psw: "green",
                tel: null,
                userDesc: "大一部威武"
            }
        }
    }

    handleChange = (e) => {
        this.setState({newUser: e.target.value});
    };
    handleClick = () => {
        let newUser = this.state.newUser;
        if (newUser) {
            this.props.onAddUser(newUser);
        }
    };

    handleUserClick = (userId) => {
        this.props.onSetCurrentUser(userId);
    };

    render() {
        let that = this.props.users;
        return (
            <div>
                <ul className='user-list'>
                    {that.map(user => {
                        return (<li key={user.userId}
                                    className={(this.props.currentUserId === user.userId) ? 'current' : ''}
                                    onClick={this.handleUserClick.bind(this, user.userId)}>
                            <span>{user.userName}</span>&nbsp;<span>{user.psw}</span>
                            <span>{user.tel}</span>&nbsp;<span>{user.userDesc}</span>
                        </li>)
                    })}
                </ul>

                <UserAdd onAddUser={this.handleClick}/>
            </div>
        );
    }
}