# cloudProject
#cloud - euerka 
是支持集群模式
#cloud - euerka client
eureka客户端也可以支持集群模式
#cloud - euerka ribbon
集成hystrix可以支持{服务限流,服务熔断,服务降级}等等功能
#cloud - euerka feign{这里是open feign}
内置hystrix可以支持{服务限流,服务熔断,服务降级}等等功能
#cloud - euerka zuul
服务网关在更新支持集群模式
#cloud - euerka config
配置中心支持云配置文件{限只支持GitHub,可以自己扩展}
#cloud - euerka zikpin and admin
服务链路配合的boot admin,可以将记录写进数据库里{mysql...}<br>
也可以自己扩展其他的框架,<br>
这里要注意版本jar的问题{具体看pom文件}
#cloud 中间件  -------->>>
#cloud - rabbitmq 中间件
rabbitmq支持Direct，Topic，Fanout，Header四种模式,<br>
用的amqp模板,当时也可以自带RabbitTemplate{test类里面有测试案例}
#cloud - mongodb 中间件
mongodb数据库,还没支持SQL语法,继续更新SQL写法,<br>
可以直接开箱即用
# 接下来更新redis,payment里面有redis栗子
