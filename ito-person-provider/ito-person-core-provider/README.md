web层-----主要对访问控制进行转发
service-----相对具体的业务逻辑服务层
manager------通用业务处理层
1 对第三方平台封装层，预处理返回结果以及转换异常信息
2 对service层通用能力的下层，如缓存方案，中间件通用处理
3 与dao层交互，对多个dao的组合复用
dao层-----数据访问层
分层领域模型
do--- 与数据表结构一一对应，通过dao层向上传输数据源对象
dto---数据传输对象，service或manager向外传输的对象
bo---业务对象，由service层输出的封装业务逻辑的对象
ao---应用对象，在web层与serviceceng之间抽象的复用对象模型，极为贴近展示层，复用度不高
vo-----显示层对象，通常是web向模板渲染引擎层传输的对象
query--数据查询对象，各层接收上层的查询请求。注意超过2个参数的查询封装，注意使用Map类来传输

controller/Tservice  vo/dto
Service/Manager ao/bo
dao do
折中方案
1 允许service/manager可以操作数据领域模型，对于这个层级来说，本来自己做的工作也是做的是业务
逻辑处理和数据封装
2 controller/Tservice层的领域模型不允许传入dao层
3 不允许dao层的数据传入到controller/Tservice
controller tService
vo              
service manager
                   do
dao
