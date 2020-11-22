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
//TODO: checkInGuests
//TODO: getGuestById
//TODO: deleteGuest
//TODO: useSlide
