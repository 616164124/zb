# 这个模块都是一些springboot的操作

#@Async的使用


### 统一回复消息
统一回复 如果后台报错，将无法获取错误，要是后台throw异常时，就不会反应在返回的消息中

常用校验注解

@Null 只能是null

@NotNull 不能为null 注意用在基本类型上无效，基本类型有默认初始值

@AssertFalse 必须为false

@AssertTrue 必须是true
字符串/数组/集合检查：(字符串本身就是个数组)

@Pattern(regexp="reg") 验证字符串满足正则

@Size(max, min) 验证字符串、数组、集合长度范围

@NotEmpty 验证字符串不为空或者null

@NotBlank 验证字符串不为null或者trim()后不为空

数值检查：同时能验证一个字符串是否是满足限制的数字的字符串

@Max 规定值得上限int

@Min 规定值得下限

@DecimalMax("10.8") 以传入字符串构建一个BigDecimal，规定值要小于这个值

@DecimalMin 可以用来限制浮点数大小

@Digits(int1, int2) 限制一个小数，整数精度小于int1；小数部分精度小于int2

@Digits 无参数，验证字符串是否合法

@Range(min=long1,max=long2) 检查数字是否在范围之间
这些都包括边界值

日期检查：Date/Calendar

@Post 限定一个日期，日期必须是过去的日期

@Future 限定一个日期，日期必须是未来的日期

其他验证：
@Vaild 递归验证，用于对象、数组和集合，会对对象的元素、数组的元素进行一一校验
@Email 用于验证一个字符串是否是一个合法的右键地址，空字符串或null算验证通过
@URL(protocol=,host=,port=,regexp=,flags=) 用于校验一个字符串是否是合法UR



### druid配置


### spring security的使用
https://www.cnblogs.com/qiantao/p/14605154.html

### spring中assert的使用
