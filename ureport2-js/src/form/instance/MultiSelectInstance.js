/**
 * Created by Jacky.Gao on 2017-10-20.
 */
import Instance from './Instance.js';
import Option from './Option.js';
// import '../../../node_modules/bootstrap-multiselect/dist/js/bootstrap-multiselect';
// import multiSelect from '../../../node_modules/multiselect-dropdown/multiselect-dropdown.min';
import multiSelect from "multiselect-dropdown/src/multiselect-dropdown.module";
import 'multiselect-dropdown/src/multiselect-dropdown.css';

export default class MultiSelectInstance extends Instance{
    constructor(seq){
        super();
        var label="多选列表"+seq;
        this.element=this.newElement(label);
        this.inputElement=$("<div>");
        this.element.uniqueId();
        this.id=this.element.prop("id");
        this.select=$("<select id='" + this.id + "_multiSelect' multiple='multiple'>");
        this.inputElement.append(this.select);
        this.element.append(this.inputElement);
        this.options=[];
        this.optionNum=1;
        for(var i=1;i<5;i++){
            this.addOption();
        }

        let multiSelectEl = this.select;
        setTimeout(function(){
            const dropdown = new multiSelect(
                document.getElementById(multiSelectEl.prop("id")),
                {className: '', maxVisibleOptions: 0}   // options
            );
            console.log(dropdown);
        })
    }
    addOption(json){
        var option=new Option("选项"+(this.optionNum++));
        if(json){
            option.initFromJson(json);
        }
        this.options.push(option);
        this.select.append(option.element);
        return option;
    }
    removeOption(option){
        var targetIndex;
        $.each(this.options,function(index,item){
            if(item===option){
                targetIndex=index;
                return false;
            }
        });
        this.options.splice(targetIndex,1);
        option.remove();
    }
    initFromJson(json){
        $.each(this.options,function(index,item){
            item.element.remove();
        });
        this.options.splice(0,this.options.length);
        super.fromJson(json);
        if(json.searchOperator){
            this.searchOperator=json.searchOperator;
        }
        var options=json.options;
        for(var i=0;i<options.length;i++){
            this.addOption(options[i]);
        }
        this.useDataset=json.useDataset;
        this.dataset=json.dataset;
        this.labelField=json.labelField;
        this.valueField=json.valueField;
    }
    toJson(){
        const json={
            label:this.label,
            optionsInline:this.optionsInline,
            labelPosition:this.labelPosition,
            bindParameter:this.bindParameter,
            type:MultiSelectInstance.TYPE,
            useDataset:this.useDataset,
            dataset:this.dataset,
            labelField:this.labelField,
            valueField:this.valueField,
            options:[]
        };
        for(let option of this.options){
            json.options.push(option.toJson());
        }
        return json;
    }
    toXml(){
        let xml=`<input-multiSelect label="${this.label}" type="${MultiSelectInstance.TYPE}" label-position="${this.labelPosition || 'top'}" bind-parameter="${this.bindParameter || ''}"`;
        if(this.useDataset){
            xml+=` use-dataset="${this.useDataset}" dataset="${this.dataset}" label-field="${this.labelField}" value-field="${this.valueField}"`;
        }
        xml+='>';
        // for(let option of this.options || []){
        //     xml+=`<option label="${option.label}" value="${option.value}"></option>`;
        // }
        xml+=`</input-multiSelect>`;
        return xml;
    }
}
MultiSelectInstance.TYPE="MultiSelect";
