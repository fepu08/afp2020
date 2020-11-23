jest.dontMock('../GuestActions');
import  * as actions from '../GuestActions';
jest.mock('axios');
import axios from 'axios';
jest.mock('../../dispatcher/Dispatcher')
import dispatcher from "../../dispatcher/Dispatcher";

describe('Tests for GuestActions', ()=>{
    beforeEach(()=>{
        jest.clearAllMocks();
    });

    // CHECK IN
    it('checks if the guest recorded successfully', ()=>{
        axios.post.mockReturnValue(Promise.resolve());
        actions.checkInGuest();
        expect(axios.post).toHaveBeenCalledTimes(1);
    });

    it('checks the recording of existing guest', ()=>{
        axios.post.mockReturnValue(Promise.reject({
            response : {
                status : 409,
                statusText : "Conflict",
                data : {
                    message : 'Conflict'
                }
            }
        }));
        dispatcher.dispatch();
        actions.checkInGuest();
        expect(axios.post).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });
})