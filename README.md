# 算法的练习
> 立个小目标。leet_code上的题目先撸个200道

搞不懂的东西，永远难受，我不喜欢。进大厂能的敲门砖啊，脑壳疼


## leetcode 题目集合

### 链表问题
  - [T19] 删除链表的倒数第N个节点(双指针保持固定的距离开始一起走)
  - [T21] 合并两个有序链表(递归与非递归的方式)
  - [T-1] 链表的反转(递归和非递归的方法)
  - [T23] 合并K个排序链表（分治合并）
  - [T24] 两两交换链表中的节点(递归和迭代)
  - [T25] K个一组翻转链表
 
### 数字之和的问题
   - [T1]  两数之和(Set集合保存走路的路径，一次遍历即可)
   - [T2]  两数相加(排序+双指针)
   - [T15] 三数之和
   - [T16] 最接近的三数之和()
   - [T18] 四数之和

### 括号问题
   - [T20] 有效的括号(用压栈的方式可以很好的解决)
   - [T22] 括号的生成？(回溯， 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号)
```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
```

### 数组问题
   -[T26] 删除排序数组中的重复项(双指针法)
   -[T27] 移除数组中的指定元素(双指针法)
   -[T28] 实现StrStr() ??
    
### 打算搁置的题目
   - [T29] 两数相除
   - [T]


