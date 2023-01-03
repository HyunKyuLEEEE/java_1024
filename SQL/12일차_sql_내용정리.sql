/*
DB객체중 시퀀스이 있다
지정한 옵션에 따라 순서대로 번호를 만들어주는 객체
트리거
트리거를 쓸 때 => 예를 들면 상품을 구매했을 때 수량이 자동으로 바뀌여야하는데 트리거를 만들어서 사용
데이터무결성을 지키기위해 만드는 것 = 트리거
참조 관계에 있는 두 테이블에서 하나의 테이블에 삽입, 삭제, 갱신 등의 연산으로 테이블의 내용이 바뀌었을 때 데이터의 일관성과 무결성 유지를 위해 이와 연관된 테이블도 연쇄적으로 변경이 이루어 질 수 있도록 하는 것을 말한다.

view 하나이상의 테이블로 이루어진 가상 테이블
기본테이블들 중에서 검색결과를 별도로 관리하고자할때 사용하는 것을 뷰라고 부른다.

외래키 제약조건 4가지
NO ACTION
데이터베이스 엔진 에서는 오류가 발생하며 부모 테이블의 행에 대한 삭제 또는 업데이트 동작이 롤백됩니다.

CASCADE
부모 테이블에서 해당 행이 업데이트되거나 삭제될 때 참조 테이블에서도 해당 행이 업데이트 또는 삭제됩니다. timestamp 열이 외래 키 또는 참조되는 키의 일부인 경우에는 CASCADE를 지정할 수 없습니다. INSTEAD OF DELETE 트리거가 있는 테이블에는 ON DELETE CASCADE를 지정할 수 없습니다. INSTEAD OF UPDATE 트리거가 있는 테이블에 대해서는 ON UPDATE CASCADE를 지정할 수 없습니다.

SET NULL
부모 테이블에서 행을 업데이트하거나 삭제하면 해당 외래 키를 구성하는 모든 값이 NULL로 설정됩니다. 이 제약 조건을 실행하려면 외래 키 열이 Null을 허용해야 합니다. INSTEAD OF UPDATE 트리거가 있는 테이블에 대해서는 지정할 수 없습니다.

SET DEFAULT
부모 테이블에서 해당 행을 업데이트하거나 삭제하면 외래 키를 구성하는 모든 값이 기본값으로 설정됩니다. 이 제약 조건을 실행하려면 모든 외래 키 열에 기본 정의가 있어야 합니다. 열이 Null을 허용하고 명시적 기본값이 설정되어 있지 않은 경우 NULL은 해당 열의 암시적 기본값이 됩니다. INSTEAD OF UPDATE 트리거가 있는 테이블에 대해서는 지정할 수 없습니다.

Union은 두 쿼리의 합집합
unionall은 중복허용
union은 중복불가

dml 데이터베이스를 관리하는 언어로 조회하거나 추가하거나 삭제하거나 하는 언어
ddl 데이터 정의어로 데이터베이스에 데이터를 생성 수정 삭제하는 언어
dcl 데이터를 제어하는 언어로 데이터베이스에 접근하거나 개체에 권한을 부여할 수 있는 언어
tcl 논리적 작업 단위인 트랜잭션에 관한 연산을 제어
트랜잭션 :  트랜잭션은 데이터베이스를 상태를 바꾸는 일종의 작업 단위이다.
COMMIT: 트랜잭션 내의 변경 사항을 영속적으로 데이터베이스에 반영한다
ROLLBACK: SAVEPOINT 혹은 마지막 커밋 시점으로 데이터베이스의 상태를 되돌린다
SAVEPOINT: 트랜잭션의 수행 도중 실패가 일어나 취소되거나, ROLLBACK 연산을 직접 수행했을 때 해당 시점으로 돌아가기 위한 체크포인트(해당 트랜잭션 내에서만 존재한다)
SET TRANSACTION: 트랜잭션을 명시적으로 시작한다

check - 해당 속성의 값을 제한을 둘 경우 하는 방법 culomn값을 특정 범위로 정의할때 사용하는 제약조건
default - 데이터를 입력하지 않았을 때 기본값

테이블은 속성(culumn)과 행으로 구성되는 요소
*/