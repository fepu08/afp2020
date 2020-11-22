import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/SlideActionConstants'

export const addSlide = ({price, slideName}) => {
    axios.post('/Slide/record',
        {
            price: price,
            slideName: slideName
        })
        .then(() => {
            fetchSlide();
            dispatcher.discpatch({action : actionConstants.clearError});
        })
        .catch((err) => {
           //dispatcher.dispatch({
           //    action : actionConstants.showError,
           //    payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
           //});
            console.log(err);
            fetchSlide();
        });
}

//TODO: getSlideById
//TODO: updateSlide
//TODO: deleteSlide

export const fetchSlide = () =>{
    axios.get('/Slide/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}