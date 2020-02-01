import React, {Component} from 'react';
import PostItem from './postItem.js';

class PostList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            user: {name: "faith"}
        };
        this.timer = null;
    }

    componentDidMount() {
        //用setTimeout 模拟异步从服务器获取数据
        this.timer = setTimeout(() => {
            this.setState({
                posts: [
                    {
                        id: 1,
                        title: "大家一起来讨论react 吧",
                        author: "张三",
                        date: "2017-01-01",
                        vote: 0
                    }, {
                        id: 2,
                        title: "前端框架你最爱哪一个",
                        author: "李四",
                        date: "2017-92-93",
                        vote: 0
                    }, {id: 3, title: "Web App 时代已经来临", author: "王五", date: "2018-5-21", vote: 0}
                ]
            })
        }, 1000);
    }

    componentWillMount() {
        if (this.timer) {
            clearTimeout(this.timer);//清除定时器
        }
    }

    handleVote = (id) => {
        //根据帖子的id进行过滤，找到待修改的vote的属性的帖子，返回新的posts对象
        const posts = this.state.posts.map(item => {
            const newItem = item.id === id ? {...item, vote: ++item.vote} : item;
            return newItem;
        });
        this.setState({
            posts
        });
    }

    handleSave = (post) => {
        const posts = this.state.posts.map(
            item => {
                const newItem = item.id === post.id ? post : item;
                return newItem;
            }
        )
        this.setState({
            posts
        })
    }


    render() {
        return (
            <div>
                帖子列表：
                <ul>
                    {this.state.posts.map(item => <PostItem key={item.id} post={item}
                                                            onVote={this.handleVote}
                                                            onSave={this.handleSave}/>)}
                </ul>
            </div>
        );
    }
}

export default PostList;