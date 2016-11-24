## grep/awk/sed 文档

***
###预备知识：正则表达式

      .：匹配任意单个字符
      []：匹配指定范围内的任意单个字符
      [^]：匹配指定范围外的任意单个字符
      字符集和：[:digit:]，[:lower:]，[:upper:]，[:punct:]，[:space:]，[:alpha:]，[:alnum:]
      对应上边：数字  ，小写字母，大写字母，标点符号，空白字符，所有字母，所有数字和字母

      for more is waiting...
***
grep、sed和awk都是文本处理工具，虽然都是文本处理工具单却都有各自的优缺点，一种文本处理命令是不能被另一个完全替换的，否则也不会出现三个文本处理命令了。只不过，相比较而言，sed和awk功能更强大而已，且已独立成一种语言来介绍。
 
 grep：文本过滤器，如果仅仅是过滤文本，可使用grep，其效率要比其他的高很多；
 
 sed：Stream EDitor，流编辑器，默认只处理模式空间，不处理原数据，如果你处理的数据是针对行进行处理的，可以使用sed；
 awk：报告生成器，格式化以后显示。如果对处理的数据需要生成报告之类的信息，或者你处理的数据是按列进行处理的，最好使用awk。

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
***
###sed: stream editor 流编辑器 

--用来把文档或字符串里面的文字经过一系列编辑命令转换为另一种格式输出,`它一次处理一行内容`

命令：

      sed  file ...
    -n：静默模式，不再显示模式空间中的内容
    -i：直接修改原文件
    -e SCRIPT -e SCRIPT：添加脚本到将要执行的命令中，可以同时执行多个脚本
    -f /PATH/TO/SED_SCORIPT：添加脚本文件中的内容到将要执行的命令中
         #sed -f /path/to/script file
    -r：表示使用扩展正则表达式
    Address:
    1、StartLine,EndLine：开始行，结束行
    如：1,100:表示从第1行到第100行
    $；最后一行
    2、/RegExp/：扩展正则表达式
    如：/^root/
    3、/pattern1/,/pattern2/：表示第一次被pattern1匹配到的行开始，至第一次被pattern2匹配到的行结束，这中间的所有行
    4、LIneNumber：指定的行
    5、StartLIne，+N：从StartLine开始，向后的N行
    Command:
    d：删除符合条件的行；
    p：显示符合条件的行，在不使用-n选项时被匹配到的行会显示两遍，因为sed处理时会把处理的信息输出
    a \string：在指定的行后面追加新行，内容为“string”,
        显示两行或多行，在每行后加\n进行换行
    i \string：在指定的行前面添加新行，内容为string
    r file：将指定的文件的内容添加至符合条件的文件中
    w file：将地址指定范围内的行另存至指定的文件中
    s/pattern/string/修饰符：查找并替换，默认只替换每行中第一次被模式匹配到的字符串
        加修饰符
         g：全局替换，如：s/pattern/string/g
         i：忽略字符大小写，如：s/pattern/string/i
    s///,s###,s@@@都可以，当所使用的分割符号与内容中显示的相同时，需使用转义字符转义    
        \(\),\1,\2：成组匹配，\1表示匹配第一个‘(’，\2表示匹配第二个‘(’
    &：引用模式匹配到的整个串
    
 ***
 ###3.awk
 使用格式：
# awk [options] 'script' file1, file2, ...
# awk [options] 'PATTERN { action }' file1, file2, ...
      
