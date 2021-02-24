/**
 * Created by Jacky.Gao on 2017-10-20.
 */
import Component from './Component.js';
import MultiSelectProperty from '../property/MultiSelectProperty.js';
import Utils from '../Utils.js';
import MultiSelectInstance from '../instance/MultiSelectInstance.js';
export default class SelectComponent extends Component{
    constructor(options){
        super(options);
        this.property=new MultiSelectProperty();
    }
    newInstance(){
        var seq=Utils.seq(this.id);
        return new MultiSelectInstance(seq);
    }
    getType(){
        return MultiSelectInstance.TYPE;
    }
    getId(){
        this.id= "multi_select";
        return this.id;
    }
}