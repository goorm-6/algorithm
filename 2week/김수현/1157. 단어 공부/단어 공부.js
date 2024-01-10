let input = require('fs').readFileSync(0).toString().trim();
word = input.toUpperCase();

// 객체 생성후 단어와 카운트 값 저장
let obj = {};
for(let i=0; i<word.length; i++) {
    if (obj[word[i]] === undefined) {
        obj[word[i]] = 1;
    } else {
        obj[word[i]] += 1;
    }
}

// 가장 큰 value 값을 가진 key 값 반환
let result = '';
let max = 0;

for (let key in obj) {
    if (obj[key] > max) {
        result = key;
        max = obj[key];
    } else if (obj[key] === max) { 
        result ='?';
    }
}

console.log(result);