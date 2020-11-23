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

    // DELETE GUEST
    it('checks if the guest delete successfully', ()=>{
        axios.delete.mockReturnValue(Promise.resolve());
        actions.deleteGuest(1);
        expect(axios.delete).toHaveBeenCalledTimes(1);
    });

    it('checks the delete of non-existing guest', ()=>{
        axios.delete.mockReturnValue(Promise.reject({
            response : {
                status : 409,
                statusText : "Conflict",
                data : {
                    message : 'Conflict'
                }
            }
        }));
        dispatcher.dispatch();
        actions.deleteGuest();
        expect(axios.delete).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // USE SLIDE
    it('checks if the guest use slide successfully', ()=>{
        axios.post.mockReturnValue(Promise.resolve());
        actions.useSlide(1, "9991460b-1786-4177-8ef3-7d61f0114710");
        expect(axios.post).toHaveBeenCalledTimes(1);
    });

    it('checks the guest use a non-existing slide', ()=>{
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
        actions.useSlide(1, "9991460b-1786-4177-8ef3-7d61f0114710");
        expect(axios.post).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // GET GUEST BY ID
    it('checks if get guest by id successfully', ()=>{
        axios.get.mockReturnValue(Promise.resolve());
        actions.getGuestById(1);
        expect(axios.get).toHaveBeenCalledTimes(1);
    });

    it('check to try to get a guest by a non-existing id', ()=>{
        axios.get.mockReturnValue(Promise.reject({
            response : {
                status : 409,
                statusText : "Conflict",
                data : {
                    message : 'Conflict'
                }
            }
        }));
        dispatcher.dispatch();
        actions.getGuestById(1);
        expect(axios.get).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // GET ALL GUESTS
    it('checks get all guests', ()=>{
        axios.get.mockReturnValue(Promise.resolve());
        actions.fetchGuest();
        expect(axios.get).toHaveBeenCalledTimes(1);

    });

    it('checks cant get all guests', ()=>{
        axios.get.mockReturnValue(Promise.reject({
            response : {
                status : 409,
                statusText : "Conflict",
                data : {
                    message : 'Conflict'
                }
            }
        }));
        dispatcher.dispatch();
        actions.fetchGuest();
        expect(axios.get).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });
})
