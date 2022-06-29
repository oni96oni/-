public static void main(String[] args) {
         
         Timer tt = new Timer();
         TimerTask tt2 = new TimerTask() {
            
            @Override
            public void run() {
               TestAuto auto = new TestAuto();
               try {
                  SqlSession session = MyClient.getSqlSession();
                  String resource = "testpakege/MyConfig.xml"; //필요없는거

                     Reader reader = Resources.getResourceAsReader(resource);//필요없는거

                     SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);//필요없는거
                  
                  Date nowDate = new Date();
                  SimpleDateFormat sendTime = new SimpleDateFormat("yyyyMMddHHmmss");
                  String sTime = sendTime.format(nowDate);
                  
                  
                  Map<String, Object> param = new HashMap<String, Object>();
                  
                  List<Map<String, Object>> rs =  session.selectList("test.testSelect", 0);
                  System.out.println(sTime);
                  System.out.println(rs);
                  session = sqlMapper.openSession();//필요없는거
                  
                  
               } catch (Exception e) {
                  e.printStackTrace();
               }
               
            }
        };
