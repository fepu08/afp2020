import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const fetchGuest = () =>{
    axios.get('/Guest/')
        .then((resp)=>{
            dispatcher.dispatch({
                action: actionConstants.refresh,
                payload: resp.data
            });
        })
        .catch((err) => {
            dispatcher.dispatch({
                action: actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
        });
}

export const checkInGuest = () => {
    axios.post('/Guest/checkInGuest')
        .then(() => {
            fetchGuest();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
        });
            fetchGuest();
        });
}
export const getGuestById = (guestId) => {
    let guests = [];
    axios.get('/Guest/' + guestId)
        .then((resp) => {
            dispatcher.dispatch({
                action : actionConstants.refresh,
                payload: guests.concat(resp.data)
            });
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
        });
}

export const deleteGuest = (deleteGuestId) => {
    axios.delete('/Guest/checkOutGuest/' + deleteGuestId)
        .then(() => {
            //TODO: meglehetne csinálni hogy a fenti error zolddel kijelezze, hogy sikeres a torles
            fetchGuest();
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchGuest();
        });
}

export const useSlide = ({slideId, watchId}) => {
    axios.post('/Guest/useSlide',
        {
            slideId : slideId,
            watchID: watchId
        })
        .then(() => {
            fetchGuest();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchGuest();
        });
}
