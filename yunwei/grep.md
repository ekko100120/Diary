## grep/awk/sedwen文档
***
###1.grep
      [root@www ~]# grep [-acinv] [--color=auto] '搜寻字符串' filename
      选项与参数：
      -a ：将 binary 文件以 text 文件的方式搜寻数据
      -c ：计算找到 '搜寻字符串' 的次数
      -i ：忽略大小写的不同，所以大小写视为相同
      -n ：顺便输出行号
      -v ：反向选择，亦即显示出没有 '搜寻字符串' 内容的那一行！
      --color=auto ：可以将找到的关键词部分加上颜色的显示喔！
```shell
  #grep --color=auto 'html$'   // 查找某目录中以.html为后缀的文档
  #grep --color=auto -v 'html$' //查找某目录中不是以.html为后缀的文档
```
