# MyUtils
一个自用工具类

# API
##  ActivityUtils:
  1.addFragmentToActivity activity中增加fragment

##  DeviceUtils：设备相关工具类
*  1. getAndroidID：获取设备AndroidID
*  2. getIMEI：获取IMEI码 需添加权限READ_PHONE_STATE
*  3. getIMSI：获取IMSI码 需添加权限READ_PHONE_STATE
*  4. getModel：获取设备型号
*  5. getMac：获取网卡地址
  
##  FormatUtils 格式化工具类
*  1.formatChange： 将指定的字符串转换成制定小数点位数的String字符串
*  2.formatChangeToDouble： 将指定的字符串转换成制定小数点位数的Double
*  3.formatChangeToFloat：将指定的字符串转换成制定小数点位数的Float
*  4.formatChange2：舍弃小数点的String字符串
*  5.formatChangeToInteger：将指定的字符串转换成制定小数点位数的Integer
*  6.add：小数的相加
##  IntentUtils 意图快捷工具
*  1.getDialIntent： 跳至拨号界面
*  2.getCaptureIntent： 拍照的意图
*  3.getInstallAppIntent： 安装App(支持7.0)
## MyPackageUtils 包工具
*  1.getSdkVersion： 获取系统版本号
*  2.getPackageInfo： 获取包名信息
*  3.getVersionName： 获取版本名
*  4.getVersionCode： 获取版本号
*  5.getPackageName： 获取包号
*  6.getChannelID： 获取Meta中标签数据
## MySharedPreferences 注册表读写类
*  1.writeToSharedPreferences： 写入注册表（键值对）
*  2.writeStringMapToSharedPreferences：写入注册表（MAP）
*  3.readStringFromSharedPreferences：读取注册表（String）
*  4.readBooleanFromSharedPreferencesDefaultFalse： 读取注册表（Boolean 默认返回false）
*  5.readBooleanFromSharedPreferencesDefaultTrue：读取注册表（Boolean 默认返回true）
*  6.readIntFromSharedPreferences：读取注册表（Int）
*  7.readLongFromSharedPreferences：读取注册表（Long）
*  8.readFloatFromSharedPreferences：读取注册表（Float）
## RegexUtils 正则表达式工具
*  1.isTel：验证电话号码
*  2.isIDCard18：验证身份证号码18位
*  3.isEmail：验证邮箱
*  4.isMatch：判断是否匹配正则
## ScreenUtils 屏幕工具类
*  1.getScreenWidth：获取屏幕的宽度（单位：px）
*  2.getScreenHeight：获取屏幕的高度（单位：px）
*  3.dp2px： dp转px
*  4.px2dp： px转dp
*  5.sp2px： sp转px
*  6.px2sp： px转sp
*  7.measureView: 测量视图尺寸
*  8.getMeasuredWidth： 获取测量视图宽度
*  9.getMeasuredHeight： 获取测量视图高度
## SDCardUtils SD卡工具类
*  1.ishasCard：是否有SD卡
*  2.getSDCardPath： SD卡路径
*  3.getSDFreeSize： SD卡剩余空间大小
*  4.makeDirs：创建目录
*  5.deleteFile：删除文件
## StringUtils String工具类
*  1.StringAppend： 字符串连接
## TimeUtils 时间工具类
*  1.millis2String：将时间戳转为时间字符串
*  2.isSameDay：是否为同一天
