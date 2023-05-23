function solution(currencyFormatter){
    return function (value){
        return currencyFormatter(',', '$', true, value);
    }
}
