//utils에서 작성한 기능을 import 해서 사용가능

import {add, pi} from "./utils";
import helloFunc from "./utils";

console.log("2+3 = ", add(2,3));

console.log("pi = ", pi);

helloFunc("TEST");

//모듈 시스템에서는 각 파일에 독립된 스코프를 제공
//다른 파일의 변수나 함수는 반드시 import를 해서 사용.

