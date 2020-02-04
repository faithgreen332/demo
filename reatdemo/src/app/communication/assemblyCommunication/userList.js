import React from 'react';

class UserList extends React.Component {

    render() {
        let that = this.props.users;
        return (
            <div>
                <ul className='user-list'>
                    <li key={that.userId}>
                        <span>{that.userName}</span>
                    </li>
                </ul>
            </div>
        );
    }
}

export default UserList;