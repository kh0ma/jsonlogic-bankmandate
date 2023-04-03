const transformJS = require("js-to-json-logic");

const myArray = ["a", "b", "c"]

// const result = myArray.map(el => el.concat("opa"))
// map(myArray, el => el.concat("opa"))

const result = transformJS('map("myArray", el => el + "opa"))');

console.log(result)
