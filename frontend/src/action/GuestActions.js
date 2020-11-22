import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestActionConstants'

export const fetchGuest = () =>{
    axios.get('/Guest/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
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
            fetchGuest();
        })
        .catch((err) => {
            console.log(err);
            fetchGuest();
        });
}

//TODO: useSlide
