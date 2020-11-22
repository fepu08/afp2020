import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/SlideActionConstants';

class SlideStore extends EventEmitter{

    _slides = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new SlideStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._slides = payload;
    store.emitChange();
})
