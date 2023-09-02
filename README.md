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

||ArrayList|LinkedList|reference|
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
       
# HashSet
* 자바 Collection 중 Set의 파생클래스

    - 중복 원소 허용 x
    - 순서 개념 없음. 즉 Collections.sort() 메소드 사용 불가.
    - 정렬 하고 싶다면, 리스트로 변환 후 정렬.

# Comparable vs Comparator
* 둘 다 인터페이스
* comparable과 comparator를 사용하려면 인터페이스 내 선언된 메소드를 반드시 '구현' 해야함.
* 객체를 비교할 수 있도록 만든다

<br>

* **Comparable**
    - compareTo(T o) 메소드를 재정의(Override/구현) 해줘야 함.
    - 자기 자신과 매개변수 객체(파라미터로 들어오는)를 비교
    - lang 패키지에 있어서 import 안해도 됨.

<br>

* **Coparator**
    - compare(T o1, T o2) 메소드를 재정의(Override/구현) 해줘야 함.
    - 두 매개변수 객체(파라미터로 들어오는)를 비교
    - util 패키지에 있음. import 필요.

<br>

**Comparator 비교 기능만 따로 두고 싶다면?**<br>
=> 익명 객체(클래스) 활용
익명 객체는 특정 구현 부분만 따로 사용하거나, 부분적으로 기능을 일시적으로 바꿔야할 시 사용할 수 있음.

<br>

```java
public class Anonymous {
    public static void main(String[] agrs) {
        
        Rectangle a = new Rectangle();
        ChildRectangle child = new ChildRectangle();

        // 익명 객체 1
        Rectangle anonymous1 = new Rectangle() {

            @Override
            int get() {
                return width;
            }
        };

        System.out.println(a.get()); // 20
        System.out.println(anonymous1.get()); // 10
        System.out.println(anonymous2.get()); // 10 * 20 * 30
        System.out.println(child.get()); // 10 * 20 * 40
    }

    // 익명 객체 2
    static Rectangle anonymous2 = new Rectangle() {
        
        int depth = 30;

        @Override
        int get() {
            return width * height * depth;
        }
    };
}

class ChildRectangle extends Rectangle {

    int depth = 40;

    @Override
    int get() {
        return width * height * depth;
    }
}

class Rectangle {
    
    int width = 10;
    int height = 20;

    int get() {
        return height;
    }
}

```

<br>

```java
public class Main {
    public static void main(String[] args) {

        // 익명 객체 구현방법 1(main 함수 안에 지역변수 처럼 non-static으로 생성)
        Comparator<Student> comp1 = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.num - o2.num;
            }
        };

    }

    // 익명 객체 구현방법 2(main 함수 밖에 정적 타입으로 선언)
    public static Comparator<Student> comp2 = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.num - o2.num;
        }
    };
}

// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator 구현할 필요 없다.
class Student {

    int age;
    int num;

    Student(int age, int num) {
        this.age = age;
        this.num = num;
    }
}
```

<br>

```java
public class Main {
    public static void main(String[] args) {
        Student a = new Student(17, 2);	// 17살 2반
        Student b = new Student(18, 1);
        Student c = new Student(15, 3);
    
        // 학급 기준 익명객체를 통해 b와 c객체를 비교
        int classBig = comp.compare(b, c);

        if(classBig > 0) {
            System.out.println("b객체가 c객체보다 크다.");
        }
        else if(classBig == 0) {
            System.out.println("두 객체의 크기가 같다.");
        }
        else {
            System.out.println("b객체가 c객체보다 작다.");
        }

        // 나이 기준 익명객체를 통해 b와 c객체를 비교
        int ageBig = comp2.compare(b, c);

        if(ageBig > 0) {
            System.out.println("b객체가 c객체보다 크다.");
        }
        else if(ageBig == 0) {
            System.out.println("두 객체의 크기가 같다.");
        }
        else {
            System.out.println("b객체가 c객체보다 작다.");
        }
    }

    // 학급 대소 비교 익명객체
    public static Comparator<Student> comp = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.num - o2.num;
        }
    };

    // 나이 대소 비교 익명객체
    public static Comparator<Student> comp2 = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    };
}

class Student {
    int age;
    int num;

    Student(int age, int num) {
        this.age = age;
        this.num = num;
    }
}
```

<br>

**<두 수의 비교 결과에 따른 작동 방식> => 오름차순**
- 음수: 두 원소의 위치 교환 X
- 양수: 두 원소의 위치 교환 O
```java
// Comparable
public int compareTo(Class o) {
    return this.value - o.value;
}

// Comparator
public int compare(Class o1, Class o2) {
    return o1.value - o2.value;
}
```

<br>

**그럼 내림차순의 경우에는?**<br>
=> 두 원소 비교한 반환값 반대로 해준다
```java
// Comparable
public int compareTo(Class o) {
    return -(this.value - o.value); // == o.value - this.value
}

// Comparator
public int compare(Class o1, Class o2) {
    return -(o1.value - o2.value); // o2.value - o1.value
}
```

<br>

```java
public class Main {
    public static void main(String[] args) {
        MyInteger[] arr = new MyInteger[10];

        // 객체 배열 초기화 (랜덤 값으로)
        for(int i=0; i<10; i++) {
            arr[i] = new MyInteger((int)(Math.random() * 100));
        }

        // 정렬 이전
        System.out.print("정렬 전: ");
        for(int i=0; i<10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();

        Arrays.sort(arr, comp); // MyInteger에 대한 Comparator을 구현한 익명객체를 넘겨줌

        // 정렬 이후
        System.out.print("정렬 후: ");
        for(int i=0; i<10; i++) {
            System.out.print(arr[i].value + " ");
        }
        System.out.println();
    }

    static Comparator<MyInteger> comp = new Comparator<MyInteger>() {

        @Override
        public int compare(MyInteger o1, MyInteger o2) {
            return o2.value - o1.value;
        }
    }
}

class MyInteger {
    int value;

    public MyInteger(int value) {
        this.value = value;
    }
}
```

<br>

**<참고>**<br>
인터페이스는 함수의 껍데기만 있는 클래스<br>
자동차를 설계한다고 가정. 이때, '자동차' 자체는 추상적인 개념.<br>
대개 자동차는 바퀴가 4개 있고, 핸들과 기어가 있는 동력 물체라는 개념이 존재.<br>
이러한 추상적 개념을 '인터페이스' 라고 보면 된다.

<br>

이러한 개념을 구체화, 즉 구현을 하여 핸들은 어떤 모양으로 할 지.<br>
바퀴는 어느 크기, 어느 위치에 둘 것인지 구체적으로 만들어 볼보 XC60 등 하나의 제품이 만들어진다.<br>
이를 바로 '클래스' 라고 보면 된다.

<br>

'인터페이스'는 어떤 사물에 대해 기본적인 '필수요소'들을 선언만 해놓은 것.<br>
'클래스'는 이러한 필수요소들을 구체적으로 '구현'하는 것.

<br>

즉, 인터페이스에 선언된 메소드(바퀴, 핸들, 기어, 동력 장치)들이 있고,<br>
이 인터페이스를 구현하는 클래스는 인터페이스에서 선언된 메소드(바퀴, 핸들, 기어, 동력 장치)를 반드시 구체화 헤야함.<br>
**=> 오버라이드(Override). 즉 재정의**

<br>

Java8부터 인터페이스에서도 일반 메소드 구현할 수 있음.<br>
보통 default나 static으로 선언된 메소드.<br>
참고로 default로 선언된 메소드는 재정의를 할 수 있고, static은 재정의 불가.

<br>

# 문자열
자바에서 문자열 비교할 땐 'equals()' 메서드 사용.<br>
'==' 연산자는 두 문자열이 메모리 상에서 같은 위치를 참조하는지 비교.<br>
문자열 내용 비교시 'equals()' 메서드 사용해야 함.

<br>

# 이분 탐색
두 부분으로 쪼개면서 탐색<br>

**기본적인 메커니즘**
1. 탐색 범위 내의 배열의 중간 인덱스 구하기
2. 중간 인덱스의 값과 key값 비교
3. 값이 중간 값보다 작으면 왼쪽 부분을, 중간 값보다 크다면 오른쪽 부분을 탐색. 같다면 해당 인덱스 반환.

<br>

**탐색 범위**<br>
왼쪽 끝을 가리키는 변수(lo), 오른쪽 끝을 가리키는 변수(hi)<br>
언제까지 반복? => lo가 hi보다 커지기 전까지 반복

<br>

```java
public static int binarySearch(int[] arr, int key) {

    int lo = 0;
    int hi = arr.length - 1;

    while(lo <= hi) {
        int mid = (lo+hi)/2;
         // key값이 mid보다 작다 -> 찾으려는 값(key값)이 mid보다 왼쪽에 있다 -> 탐색 범위 hi를 줄인다
        if(key < arr[mid]) {
            hi = mid - 1;
        } 
        
        // key값이 mid보다 크다 -> 찾으려는 값(key값)이 mid보다 오른쪽에 있다 -> 탐색범위 lo를 키운다
        else if(key > arr[mid]) {
            lo = mid + 1;
        }

        // key == arr[mid]
        else {
            return mid;
        }
    }

    // 찾고자 하는 값이 존재하지 않을 경우
    return -1;
}
```

<br>

**중복 원소 존재 시**<br>
중복 원소의 lo, hi를 알아낸다.<br>
중복원소에 대한 길이 = 상한 - 하한<br>
일단, lower bound(하한), upper bound(상한) 알아야 함.

**lower bound**<br>
찾고자 하는 값 **이상**의 값이 처음으로 나타나는 위치

**upper bound**<br>
찾고자 하는 값을 **초과**한 값을 처음 만나는 위치

<br>

```java
private static int lowerBound(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length; // -1을 하면 while 조건식 달라짐. 
    // 탐색 범위는 lo이상 hi미만. 그래서 hi = n-1 아님. 

    while(lo < hi) { // lo<=hi 안하는 이유는 lo==hi일시, hi = mid 해주기 때문에 무한루프에 빠진다.
        int mid = (lo+hi)/2;

        if(key <= arr[mid]) {
            hi = mid;
        }
        else {
            lo = mid + 1;
        }
    }
    return lo;
}

private static int upperBound(int[] arr, int key) {
    int lo = 0;
    int hi = arr.length;

    while(lo < hi) {
        int mid = (lo+hi)/2;

        if(key < arr[mid]) {
            hi = mid;
        }
        else {
            lo = mid + 1;;
        }
    }
    return lo;
}
```