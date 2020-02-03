import React from 'react';

/**
 * 挂载节点的通信一般是在componentdidMount方法进行
 */
class UserListContainer extends React.Component {
    componentDidMount() {
        var that = this;
        fetch('path/to/user-api').then(function (response) {
            response.json().then(function (data) {
                that.setState({user: data});
            })
        })
    }
}

export default UserListContainer;