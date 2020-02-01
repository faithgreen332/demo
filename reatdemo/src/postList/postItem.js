import React, {Component} from 'react';
import './css/postItem.css';
import handPointer from '../icons/svg/hand-pointer.svg';

class PostItem extends Component {
    constructor(props) {
        super(props);
        this.state = {
            editing: false,//帖子是否处于编辑状态
            post: props.post
        };
    }

    componentWillReceiveProps(nextProps) {
        //父组件更新post后，子组件更新state
        if (this.props.post !== nextProps.post) {
            this.setState({
                post: nextProps.post
            });
        }
    }

    /**
     * 处理点赞时间，把他交给父组件的onVote
     */
    handleVote = () => {
        this.props.onVote(this.props.post.id);
    }

    /**
     * 保存/编辑 按钮点击后的逻辑
     */
    handleEditPost = () => {
        const editing = this.state.editing;
        //如果处于编辑状态，调用父组件传递的onSave方法保存帖子
        if (editing) {
            this.props.onSave({...this.state.post, date: this.getFormatData});
        }
        this.setState({
            editing: !editing
        });
    }

    /**
     *  处理标题textarea值得变化
     */
    handleTitleChange = (event) => {
        const newPost = {...this.state.post, title: event.target.value};
        this.setState({
            post: newPost
        })
    }

    /**
     * 获取标题变化内容
     */
    getFormatData = () => {

    }

    render() {
        const {post} = this.state;
        return (
            <li className='item'>
                <div className='title'>
                    {this.state.editing ? <form><textarea value={post.title}
                                                          onChange={this.handleTitleChange}/>
                    </form> : post.title}
                </div>
                <div>
                    创建人：<span>{post.author}</span>
                </div>
                <div>创建时间：<span>{post.date}</span></div>
                <div className='like'>
                    <span>
                        <img alt='vote' src={handPointer} onClick={this.handleVote}/>
                    </span>
                    <span>
                        {post.value}
                    </span>
                </div>
                <div>
                    <button
                        onClick={this.handleEditPost}>{this.state.editing ? "保存" : "编辑"}</button>
                </div>
            </li>
        )
    }
}

export default PostItem;