import React from 'react';

export default class JsonUtils extends React.Component {
    /**
     * 字符串转换成json
     * @param data
     * @returns {any}
     * @constructor
     */
    static StringToJson(data) {
        return JSON.parse(data);
    }

    /**
     * json转字符串
     * @param data
     * @returns {string}
     */
    static jsonToString(data) {
        return JSON.stringify(data);
    }

    /**
     * map转字符串
     * @param map
     * @returns {string}
     */
    static mapToJson(map) {
        return JSON.stringify(JsonUtils.strMapToJson(map));
    }

    /**
     * 字符串转map
     * @param data
     * @returns {*}
     */
    static jsonToMap(str) {
        return JsonUtils.jsonToStrMap(JSON.parse(str));
    }

    /**
     * map转外对象（map所有键都是字符串，可以将其转为对象）
     * @param strMap
     * @returns {any}
     */
    static strMapToJson(strMap) {
        let obj = Object.create(null);
        for (let [k, v] of strMap) {
            obj[k] = v;
        }
        return obj;
    }

    /**
     * 对象转为map
     * @param obj
     * @returns {Map<any, any>}
     */
    static jsonToStrMap(obj) {
        let strMap = new Map();
        for (let k of Object.key(obj)) {
            strMap.set(k, obj[k]);
        }
        return strMap;
    }
}