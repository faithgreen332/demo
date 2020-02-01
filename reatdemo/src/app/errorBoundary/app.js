import React from 'react';
import ErrorBoundary from "./errorBoundary";
import Profile from "./profile";

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: {name: "react"}
        };
    }

    onClick = () => {
        this.setState({user: null});
    }

    render() {
        return (
            <div>
                <ErrorBoundary>
                    <Profile user={this.state.user}/>
                </ErrorBoundary>
                <button onClick={this.onClick}>更新</button>
            </div>
        );
    }
}

export default App;