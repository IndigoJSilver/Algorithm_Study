# Algorithm_Study


# List vs ArrayList
* 인터페이스와 클래스. 아래의 결과는 같음. 다만 list가 더 유연하다. 즉 generic하게 쓸 수 있음.   
   
```java
List <Object> list = new ArrayList <>();
```
-> 도형 list = new 정사각형();   

```java
ArrayList <Object> list = new ArrayList <>();   
```
-> 정사각형 list = new 정사각형();   


# ArrayList vs LinkedList
1. **ArrayList(배열과 유사)**   
    * 중복 허용, 순서 유지하며 인덱스로 데이터 관리.   
    * 클래스이므로 배열 추가, 삭제 하는 메소드 존재.   
    * 추가했을 때, 배열 크기가 동적으로 커지지 않아, 꽉 차면 더 큰 용량의 배열을 만들어 옮겨야 함.   
   
* **API 종류**   
    - add(E element) -> 원소 마지막에 추가   
    - add(int index, E element) -> 원소를 지정된 위치에 추가   
    - remove(int index) -> 원소의 인덱스로 삭제   
    - get(int index) -> 인덱스에 해당하는 원소 찾기   
   
2. **LinkedList(배열 단점 보안 위해)**   
    * 크기 변경 불가 -> 새 배열 생성하여 복사해야함.   
    * 비순차적인 데이터 추가, 삭제 시간 오래 걸림   
   
* **API 종류**   
    - 상동   
   
   <br>

* 순차 추가 -> LinkedList가 우위. ArrayList는 공간 부족으로 인한 배열 복사가 일어나기 때문.   
* 순차 삭제 -> ArrayList가 우위. 노드 링크 끊고 하는 작업보다 배열에서 요소 삭제하는 것이 더 빠름.   
* 중간 데이터 추가 -> LinkedList가 우위. ArrayList는 배열 복사 및 데이터 이동이 발생하기 때문.   
* 중간 삭제 -> LinkedList가 우위. 요소 이동 없이 노드 포인팅만 교체하면 됨.   
* 접근 시간 -> ArrayList가 우위. 메모리 저장 구조상 배열은 연속된 공간에 저장되고 인덱스로 단번에 접근하기 때문.   
   
   <br>

* **시간복잡도**   
| |ArrayList|LinkedList|reference|
|---|---|---|---|
|add()|O(1)|O(1)|LinkedList|
|add(index, value)|O(N)|O(1) + search time / O(N)|LinkedList|
|remove(index)|O(N)|O(1)|LinkedList| 
|remove(value)|O(N)|O(1)|LinkedList|   
|get(index)|O(1)|O(N)|ArrayList|   
|indexOf(value)|O(N)|O(N)|ArrayList|


# LinkedList는 의외로 잘 사용되지 않음
* 삽입 / 삭제가 빈번하면 LinkedList를, 요소 가져오기가 빈번하면 ArrayList를 사용하면 된다 라지만, 사실 성능면에서 둘은 큰 차이가 없다.   
* 예를 들어, ArrayList는 리사이징 과정에서 배열 복사하는 추가 시간이 들지만, 배열을 새로 만들고 for문을 돌려 기존 요소를 일일히 대입하는 그러한 처리가 아니라, 내부적으로 잘 튜닝이 되고 최적화 되어있다. 그래서 우리가 생각하는 것처럼 전혀 느리지 않다.   
-> 체감상 차이 크지 않음.   


# Queue
* **Queue의 구현체는 LinkedList.**   
    - 큐는 항상 첫 번째 데이터를 삭제하므로 ArrayList를 사용하게 되면 빈공간을 채우기 위해 데이터의 복사가 발생 -> 비효율적   
    - 그래서 중간 데이터 추가/삭제 쉬운 LinkedList 사용.   
   
* **Queue API**   
    - add() -> 맨 뒤에 삽입. 추가 성공 true, 꽉 차면 에러   
    - offer() -> 맨 뒤에 삽입. 추가 성공 true, 실패 false 반환   
    - remove() -> 맨 앞에 있는 값 반환 후 삭제. 비어있으면 에러   
    - poll() -> 맨 앞에 있는 값 반환 후 삭제. 비어있으면 null 반환   
    - clear() -> 큐 비우기   
    - element() -> 맨 앞에 있는 값 반환. 비어있으면 에러   
    - peek() -> 맨 앞에 있는 값 반환. 비어있으면 null 반환   
    - 에러 -> add, remove, element   
    - null, false -> offer, poll, peek   


# PriorityQueue
* **PriorityQueue 이용하는 문제**   
    - 힙은 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조   
    - 우선순위 큐는 각 요소들이 각각의 우선 순위를 갖고 있고, 요소들의 대기열에서   
    - 우선 순위가 높은 요소가 우선 순위가 낮은 요소보다 먼저 제공되는 자료구조   
    - -> 우선순위가 높은 순대로 요소를 제공받음   

    <br>

    - 우선순위 큐를 구현하는 데 있어 가장 대표적인 구현 방식이 힙을 활용하는 방식   
    - 부모 노드는 항상 자식 노드보다 우선순위가 높다   
    - 내장되어 있는 우선순위 큐 우선순위 -> 오름차순 => 최소힙   

    <br>

    - max heap   
    ```java
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    ``` 
       
    <br>

    - min heap   
    ```java
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ``` 
       