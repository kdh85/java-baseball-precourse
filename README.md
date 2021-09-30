# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

##기능 목록
* 1~9까지의 자연수를 사용한다.
* 범위안의 숫자를 사용하여 서로 다른 수로 이루어진 3자리 자연수를 생성한다.
* 숫자와 자리수가 일치하는지를 확인한다.
* 숫자와 자리수가 일치하면 스트라이크.
* 숫자만 일치하고 자리수가 일치하지 않으면 볼.
* 숫자가 일치하지 않으면 낫싱.
* 피칭한 결과에 대한 상태들의 집합이 존재한다.
* 숫자한자리가 야구공 하나를 의미한다.
* 야구공3개는 숫자 3자리를 의미한다.
* 각 야구공은 숫자,순서를 가지고 있어야 한다.
* 공들의 집합단위가 3구의 행위를 의미한다.
* 피칭한 결과들 담을 최종결과가 필요하다.
* 최종결과를 통해서 한번 시행한 결과내용을 한줄의 문자열로 출력한다.
* 3개의 공이 스트라이크가 되면 게임이 종료된다.
* 종료된 게임을 재시작하거나 완전 종료할 수 있다.
* 재시작을 원하면 1을 입력한다.
* 종료를 원하면 2를 입력한다.

##도메인 구성 예상
* 볼의 숫자, 볼의 위치 -> 볼 -> 볼의 모음
* 볼의 결과 상태 -> 피칭 결과
