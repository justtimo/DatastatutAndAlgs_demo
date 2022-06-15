package com.example.datastruct.ch3.linked.circleSingleLinked;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@ToString
public class CircleSingleLinked {
    private CircleSingleNode first;

    public CircleSingleLinked() {
        first = new CircleSingleNode(0, "first");
    }

    public CircleSingleNode add(int num) {
        CircleSingleNode current = first;
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                first = new CircleSingleNode(i + 1, String.valueOf(i + 1));
                first.setNext(first);
                current = first;
            } else {
                current.setNext(new CircleSingleNode(i + 1, String.valueOf(i + 1)));
                current=current.getNext();
                //error. 这种方式导致的问题是: 和上面的 new CircleNode 不是同一个对象了
//                current = new CircleSingleNode(i + 1, String.valueOf(i + 1));
                current.setNext(first);
            }
        }
        return current;
    }

    public void add(List<CircleSingleNode> circleSingleNodes) {
        CircleSingleNode current = first;
        for (int i = 0; i < circleSingleNodes.size(); i++) {
            if (i == 0) {
                first = circleSingleNodes.get(i);
                first.setNext(first);
                current = first;
            } else {
                current.setNext(circleSingleNodes.get(i));
                current = circleSingleNodes.get(i);
                circleSingleNodes.get(i).setNext(first);
            }
        }
    }

    public int size() {
        CircleSingleNode current = first;
        if (current == null) {
            return 0;
        } else if (current.getNext() == first) {
            return 1;
        } else {
            int i = 1;
            while (current.getNext() != first) {
                i++;
                current = current.getNext();
            }
            return i;
        }
    }

    public void delete(Integer num) {
        CircleSingleNode current = first;
        if (first == null) {
            throw new RuntimeException("链表为空");
        }
        if (current.getNext() == null) {
            if (first.getNo().equals(num)) {
                first = null;
                return;
            } else {
                throw new RuntimeException("要删除的数据不存在");
            }
        }
        if (first.getNext() != null) {
            while (current.getNext() != first) {
                if (current.getNext().getNo().equals(num)) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
            }

        }
    }

    /**
     * 约瑟夫问题:n 个人围成一个圈, 约定编号为 k 的人从 1 开始报数, 数到 m 的人出列,他的下一位从 1 开始报数, 数到 m 的那个人出列,依次类推,直到所有人都出列.
     * 例如: 4 个数据, 从第2个开始,每隔 2 个弹出此数据. 并从下一个数据重新开始
     * [1,2,3,4,5]
     * 第一次输出: [3], 数据为[1,2,4,5],从 4 开始
     * 第二次输出的是:[5],数据为[1,2,4],从 1 开始
     * 第三次输出的是:[2],数据为[1,4],从 4 开始
     * 第二次输出的是:[1],数据为[4],此时只剩下一个, first=current
     *
     * @param startNum 从第几个开始
     * @param interval 间隔几个
     *///约瑟夫:
    public void yuesefuCircle(Integer startNum, Integer interval) {
        if (startNum > size()) {
            throw new RuntimeException("超出最大数量" + size());
        }
        //找到最后一个结点,方便: 如果删除第一个结点,那么可以直接指向第一个节点的后继
        CircleSingleNode lastNode = first;
        while (true) {
            if (lastNode.getNext() == first) {
                break;
            }
            lastNode = lastNode.getNext();
        }
        //先根据开始的 num 确定收尾结点的位置
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            lastNode = lastNode.getNext();
        }
        //根据间隔, 确定要删除的元素
        while (true) {
            //直到圈中只有一个结点
            if (lastNode == first) {
                System.out.println("最后剩余的元素是: " + first.getNo() + "{" + first.getName() + "}");
                lastNode = null;
                break;
            }
            for (int i = 0; i < interval - 1; i++) {
                first = first.getNext();
                lastNode = lastNode.getNext();
            }
            System.out.println("删除的元素是: " + first.getNo() + "{" + first.getName() + "}");
            //此时已经确定要删除的结点.修改指针位置.first 后移表示从删除结点的后一个开始报数.尾结点的后继改为新的 first
            first = first.getNext();
            lastNode.setNext(first);
        }
    }
}

class Test {
    public static void main(String[] args) {
        CircleSingleLinked linked = new CircleSingleLinked();
//        List<CircleSingleNode> circleSingleNodes = Arrays.asList(
//                new CircleSingleNode(1, "theshy"),
//                new CircleSingleNode(2, "rookei"),
//                new CircleSingleNode(3, "uzi"),
//                new CircleSingleNode(4, "pdd"),
//                new CircleSingleNode(5, "jack"));
//        linked.add(circleSingleNodes);
        CircleSingleNode add = linked.add(20);

        int size = linked.size();

        linked.yuesefuCircle(1, 3);

//        linked.delete(4);

        System.out.println(linked);
    }
}