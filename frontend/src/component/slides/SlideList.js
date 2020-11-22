import React from 'react';
import {default as store} from '../../store/SlideStore';
import SlideListItem from "./SlideListItem";
import {Row} from "react-bootstrap";

class SlideList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {slides : []};
        this._updateState = this._updateState.bind(this);
    }

    componentDidMount() {
        store.addChangeListener(this._updateState);
    }

    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({slides : store._slides});
    }

    render() {
        return(
            <Row className={"w-100"}>
                {this.state.slides.map(({id, price, slideName}, index)=>{
                    return(
                        <SlideListItem
                            key={index}
                            id={id}
                            price={price}
                            slideName={slideName}
                        />
                    );
                })}
            </Row>
        );
    }

}

export default SlideList;
