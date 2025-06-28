# Colorful Life - 多彩生活社交平台

## 项目简介

Colorful Life 是一个基于 Spring Boot 开发的社交平台，为用户提供签到分享、瞬间创作、评论互动等功能。用户可以记录生活中的精彩瞬间，与朋友分享快乐时光。

## 功能特性

### 用户管理
- ✅ 用户注册与登录
- ✅ 个人资料管理
- ✅ 用户权限控制（普通用户/管理员）
- ✅ 用户搜索功能

### 签到系统
- ✅ 每日签到打卡
- ✅ 签到内容分享（文字、图片）
- ✅ 签到排行榜
- ✅ 签到历史记录
- ✅ 签到点赞功能

### 瞬间创作
- ✅ 发布生活瞬间
- ✅ 图片上传功能
- ✅ 瞬间内容管理
- ✅ 瞬间点赞功能

### 互动功能
- ✅ 评论系统
- ✅ 点赞功能
- ✅ 内容搜索
- ✅ 频道分类

### 管理功能
- ✅ 内容审核管理
- ✅ 用户管理
- ✅ 公告发布
- ✅ 推荐内容管理

## 技术栈

### 后端技术
- **框架**: Spring Boot 2.4.3
- **数据库**: MySQL
- **ORM**: MyBatis
- **分页**: PageHelper
- **API文档**: Swagger 2.9.2
- **工具库**: Lombok
- **数据验证**: Spring Validation
- **开发工具**: Spring Boot DevTools

### 前端技术
- 支持跨域访问
- 文件上传支持

### 部署技术
- **容器化**: Docker
- **JDK版本**: OpenJDK 17
- **构建工具**: Maven 3.9.9

## 项目结构

```
colorful_life/
├── src/main/java/com/hqq/colorful_life/
│   ├── ColorfulLifeApplication.java    # 启动类
│   ├── config/                         # 配置类
│   ├── filter/                         # 过滤器
│   ├── common/                         # 公共组件
│   ├── util/                           # 工具类
│   ├── exception/                      # 异常处理
│   └── model/                          # 业务模型
│       ├── controller/                 # 控制器层
│       ├── service/                    # 服务层
│       ├── dao/                        # 数据访问层
│       ├── domain/                     # 实体类
│       ├── request/                    # 请求对象
│       └── response/                   # 响应对象
├── src/main/resources/
│   ├── application.yml                 # 配置文件
│   ├── mapperxml/                      # MyBatis映射文件
│   └── static/                         # 静态资源
├── web/                                # Web资源
├── pom.xml                             # Maven配置
├── Dockerfile                          # Docker配置
└── README.md                           # 项目说明
```

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Docker (可选)

### 本地开发

1. **克隆项目**
```bash
git clone https://github.com/via-He/colorful_life.git
cd colorful_life
```

2. **配置数据库**
```bash
# 创建数据库
CREATE DATABASE colorful_life CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# 配置环境变量或修改 application.yml
DB=colorful_life
DB_URL=jdbc:mysql://localhost:3306/colorful_life?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
DB_USER=your_username
DB_PASSWORD=your_password
```

3. **运行项目**
```bash
# 编译项目
mvn clean compile

# 运行项目
mvn spring-boot:run
```

4. **访问应用**
- 应用地址: http://localhost:8880
- API文档: http://localhost:8880/swagger-ui.html

### Docker 部署

1. **构建镜像**
```bash
docker build -t colorful-life .
```

2. **运行容器**
```bash
docker run -d -p 8880:8880 \
  -e DB=colorful_life \
  -e DB_URL=jdbc:mysql://your-mysql-host:3306/colorful_life \
  -e DB_USER=your_username \
  -e DB_PASSWORD=your_password \
  colorful-life
```

## API 接口文档

### 用户相关接口

#### 用户注册
```
POST /user/register
参数: userName, password
```

#### 用户登录
```
POST /user/login
参数: userName, password
```

#### 管理员登录
```
POST /user/adminLogin
参数: userName, password
```

#### 用户登出
```
POST /user/logout
```

#### 更新个人资料
```
POST /user/update
参数: UpdateUserReq对象
```

### 签到相关接口

#### 用户签到
```
POST /sign/signIn
参数: content, channelName, title
```

#### 查看签到列表
```
GET /sign/listSign
参数: pageNum, pageSize
```

#### 签到排行
```
GET /signOrder
参数: pageNum, pageSize
```

#### 签到点赞
```
GET /sign/pink
参数: signId
```

### 瞬间创作接口

#### 发布瞬间
```
POST /create/add
参数: content, channelName
```

#### 查看瞬间列表
```
GET /create/listAll
参数: pageNum, pageSize
```

#### 瞬间点赞
```
GET /create/pink
参数: createItemId
```

### 评论相关接口

#### 查看瞬间评论
```
POST /comment/itemDetail
参数: createItemId
```

#### 查看签到评论
```
POST /comment/signDetail
参数: signId
```

#### 删除评论
```
POST /comment/delete
参数: commentId
```

### 搜索功能

#### 搜索签到
```
GET /searchSign
参数: pageNum, pageSize, keyword
```

#### 搜索瞬间
```
GET /searchMoment
参数: pageNum, pageSize, keyword
```

#### 搜索用户
```
GET /searchUser
参数: pageNum, pageSize, keyword
```

### 管理功能

#### 查看所有用户
```
GET /user/admin/allUser
参数: pageNum, pageSize
```

#### 删除用户
```
GET /user/admin/delete
参数: userId
```

#### 发布公告
```
POST /notice/admin/addNotice
参数: content
```

## 配置说明

### 环境变量
- `PORT`: 服务端口 (默认: 8880)
- `DB`: 数据库名称
- `DB_URL`: 数据库连接URL
- `DB_USER`: 数据库用户名
- `DB_PASSWORD`: 数据库密码

### 文件上传配置
- 最大请求大小: 100MB
- 最大文件大小: 50MB
- 上传目录: 配置在 `file.upload.dir` 中

## 开发指南

### 代码规范
- 使用 Lombok 简化代码
- 统一异常处理
- 使用 Swagger 注解文档化API
- 遵循 RESTful API 设计规范

### 数据库设计
- 使用 MyBatis 进行数据访问
- 支持分页查询
- 使用 PageHelper 插件

### 安全考虑
- 密码使用 MD5 加密
- 用户会话管理
- 权限控制过滤

## 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 联系方式

- 作者: Qingqing.He
- 邮箱: [viahe5141@gmail.com]

## 更新日志

### v0.0.1-SNAPSHOT
- 初始版本发布
- 实现基础用户管理功能
- 实现签到和瞬间分享功能
- 实现评论和点赞功能
- 实现管理后台功能 
