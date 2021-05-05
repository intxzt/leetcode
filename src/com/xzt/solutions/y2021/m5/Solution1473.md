<p>在一个小城市里，有&nbsp;<code>m</code>&nbsp;个房子排成一排，你需要给每个房子涂上 <code>n</code>&nbsp;种颜色之一（颜色编号为 <code>1</code> 到 <code>n</code>&nbsp;）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要被重新涂色。</p>

<p>我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 <code>houses = [1,2,2,3,3,2,1,1]</code> ，它包含 5 个街区&nbsp;<code> [{1}, {2,2}, {3,3}, {2}, {1,1}]</code> 。）</p>

<p>给你一个数组&nbsp;<code>houses</code>&nbsp;，一个&nbsp;<code>m * n</code>&nbsp;的矩阵&nbsp;<code>cost</code>&nbsp;和一个整数&nbsp;<code>target</code>&nbsp;，其中：</p>

<ul>
	<li><code>houses[i]</code>：是第&nbsp;<code>i</code>&nbsp;个房子的颜色，<strong>0</strong>&nbsp;表示这个房子还没有被涂色。</li>
	<li><code>cost[i][j]</code>：是将第&nbsp;<code>i</code>&nbsp;个房子涂成颜色&nbsp;<code>j+1</code>&nbsp;的花费。</li>
</ul>

<p>请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成&nbsp;<code>target</code>&nbsp;个街区。如果没有可用的涂色方案，请返回&nbsp;<strong>-1</strong>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
<strong>输出：</strong>9
<strong>解释：</strong>房子涂色方案为 [1,2,2,1,1]
此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
<strong>输出：</strong>11
<strong>解释：</strong>有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, n = 2, target = 5
<strong>输出：</strong>5
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
<strong>输出：</strong>-1
<strong>解释：</strong>房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == houses.length == cost.length</code></li>
	<li><code>n == cost[i].length</code></li>
	<li><code>1 &lt;= m &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= 20</code></li>
	<li><code>1 &lt;= target&nbsp;&lt;= m</code></li>
	<li><code>0 &lt;= houses[i]&nbsp;&lt;= n</code></li>
	<li><code>1 &lt;= cost[i][j] &lt;= 10^4</code></li>
</ul>
<div>
    <div>Related Topics</div>
    <div><li>动态规划</li></div>
</div>

## 分析

- 将房区初始颜色编码从0开始计算，-1表示未涂颜色。
- 记`dp[i][j][k]`为第`i`个房子涂成颜色`j`的花费，它属于第`k`个街区
- 我们讨论第`i`个房子花费：若`i!=0`，设第`i-1`个房子颜色为`j0`
    - 对于`houses[i] = -1`，即房子未涂颜色。分为两种情况：
        - `j = j0`：颜色和`i-1`一致，`i`和`i-1`属于同一街区，得如下转移方程：

          `dp[i][j][k] = dp[i-1][j][k] + const[i][j]`
        - `j != j0`：颜色变化，`i`和`i-1`不属于同一街区，得如下转移方程：

          `dp[i][j][k] = dp[i-1][j0][k-1] + const[i][j]`
    - 对于`houses[i] != -1`，即房子有初始颜色j，这种情况必须将房子涂成颜色j。同样分为两种情况：
        - `j = j0`：颜色和`i-1`一致，`i`和`i-1`属于同一街区，这时不需要额外为i涂色。得如下转移方程：

          `dp[i][j][k] = dp[i-1][j][k]`
        - `j != j0`：颜色变化，`i`和`i-1`不属于同一街区，这时不需要额外为i涂色，得如下转移方程：

          `dp[i][j][k] = dp[i-1][j0][k-1]`
- 若`i = 0`，由于第一个房子，所以`k = 0`，花费不由上一个房子转移得到。，分为两种情况：
    - `houses[i] = -1`，即房子未涂颜色，花费：`const[i][j]`
    - `houses[i] != -1`，即房子有初始颜色j，`j = j0`，花费：0

## 转化为代码：
