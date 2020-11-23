jest.dontMock('../SlideActions');
import  * as actions from '../SlideActions';
jest.mock('axios');
import axios from 'axios';
jest.mock('../../dispatcher/Dispatcher')
import dispatcher from "../../dispatcher/Dispatcher";

describe('Tests for GuestActions', ()=> {
    beforeEach(() => {
        jest.clearAllMocks();
    });

    // ADD SLIDE
    it('checks if add slide record succesfully', ()=>{
        axios.post.mockReturnValue(Promise.resolve());
        actions.addSlide(1100, "The Big Joel");
        expect(axios.post).toHaveBeenCalledTimes(1);
    });

    it('checks if cant add slide', ()=>{
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
        actions.addSlide(1100, "The Big Joel");
        expect(axios.post).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });
});