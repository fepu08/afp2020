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
    it('checks if add slide record successfully', ()=>{
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

    // GET SLIDE BY ID
    it('checks if get slide record by id successfully', ()=>{
        axios.get.mockReturnValue(Promise.resolve());
        actions.getSlideById(1);
        expect(axios.get).toHaveBeenCalledTimes(1);
    });

    it('checks if cant slide id non-exists', ()=>{
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
        actions.getSlideById(1);
        expect(axios.get).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // UPDATE SLIDE
    it('checks if can update slide', ()=>{
        axios.put.mockReturnValue(Promise.resolve());
        actions.updateSlide(1, 2200, "just small joel" );
        expect(axios.put).toHaveBeenCalledTimes(1);
    });

    it('checks if cant slide id non-exists', ()=>{
        axios.put.mockReturnValue(Promise.reject({
            response : {
                status : 409,
                statusText : "Conflict",
                data : {
                    message : 'Conflict'
                }
            }
        }));
        dispatcher.dispatch();
        actions.updateSlide(1, 2200, "just small joel")
        expect(axios.put).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // DELETE SLIDE BY ID
    it('checks if can delete slide by id', ()=>{
        axios.delete.mockReturnValue(Promise.resolve());
        actions.deleteSlideById(1);
        expect(axios.delete).toHaveBeenCalledTimes(1);
    });

    it('checks if cant delete slide id non-exists', ()=>{
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
        actions.deleteSlideById(1)
        expect(axios.delete).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });

    // GET ALL SLIDES
    it('checks if can get all slides', ()=>{
        axios.get.mockReturnValue(Promise.resolve());
        actions.fetchSlide();
        expect(axios.get).toHaveBeenCalledTimes(1);
    });

    it('checks if cant slide id non-exists', ()=>{
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
        actions.fetchSlide()
        expect(axios.get).toHaveBeenCalledTimes(1);
        expect(dispatcher.dispatch).toHaveBeenCalledTimes(1);
    });
});