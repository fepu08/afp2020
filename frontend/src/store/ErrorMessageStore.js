import {EventEmitter} from 'events';
import {default as dispatcher} from '../dispatcher/Dispatcher';
import * as complexNumberActionConstants from '../dispatcher/ComplexNumberActionConstants';
import * as guestActionConstants from '../dispatcher/GuestActionConstants';
import * as slideActionConstants from '../dispatcher/SlideActionConstants';

class ErrorMessageStore extends EventEmitter{

    _errorMsg = "";

    emitChage(){
        this.emit('Change');
    }

    addOnChangeListener(callback){
        this.addListener('Change', callback);
    }

    removeOnChangeListener(callback){
        this.removeListener('Change',callback);
    }
}
const store = new ErrorMessageStore();
export default store;

// ComplexNumbers
dispatcher.register(({action,payload})=>{
    console.log({action : action, payload : payload});
    if(action !== complexNumberActionConstants.showError){
        return;
    }
    store._errorMsg = payload;
    store.emitChage();
});

dispatcher.register(({action})=>{
   if(action !== complexNumberActionConstants.clearError) return;
   store._errorMsg = "";
   store.emitChage();
});

// Guests
dispatcher.register(({action,payload})=>{
    console.log({action : action, payload : payload});
    if(action !== guestActionConstants.showError){
        return;
    }
    store._errorMsg = payload;
    store.emitChage();
});

dispatcher.register(({action})=>{
    if(action !== guestActionConstants.clearError) return;
    store._errorMsg = "";
    store.emitChage();
});

// Slides
dispatcher.register(({action,payload})=>{
    console.log({action : action, payload : payload});
    if(action !== slideActionConstants.showError){
        return;
    }
    store._errorMsg = payload;
    store.emitChage();
});

dispatcher.register(({action})=>{
    if(action !== slideActionConstants.clearError) return;
    store._errorMsg = "";
    store.emitChage();
});