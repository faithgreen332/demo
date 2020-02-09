import React from 'react';
import PropTypes from 'prop-types';

export default class UserAdd extends React.Component {
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
    }

    handleClick = () => {
        const newUser = this.state.newUser;

        if (newUser) {
            this.context.onAddUser(newUser);
        }
    }

    render() {
        return (
            <div>
                <input onChange={this.handleChange} value={this.state.newUser}/>
                <button onClick={this.handleClick}>新增</button>
            </div>
        )
    }
}

UserAdd.contextType = {
    onAddUser: PropTypes.func
}