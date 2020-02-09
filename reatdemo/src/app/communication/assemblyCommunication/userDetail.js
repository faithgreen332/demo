import React from 'react';

export default function UserDetail(props) {
    return (
        <div>{props.currentUser ? (
            <ul>
                <li>用户名：{props.currentUser.userName}</li>
                <li>用户电话：{props.currentUser.tel}</li>
                <li> 用户描述：{props.currentUser.userDesc}</li>
            </ul>
        ) : ""}
        </div>
    )
}