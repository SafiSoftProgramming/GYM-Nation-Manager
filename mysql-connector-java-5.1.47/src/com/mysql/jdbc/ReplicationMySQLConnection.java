dex
035 #� (:�7�^�=�	����}͢S���  p   xV4        �  H   p      �     �     �          �  t
    �  �  �  �  �  �  �  �  �    (  =  Z  �  �  �  ,	  a	  �	  �	  �	  �	  �	  �	  	
  
  1
  G
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  �
  0  8  B  J  R  \  f    �  �  �  �  �  �  �  �  �  �  	      '  1  8  A  G  K           	   
                                                   $   &                                                  \                  d        p                  p                  \        x        �  "      �         �         �  !      �         �  #      �  "      �  %      �  	      	  >   	 
 A              
 *     ?     '        	     	     	  (   	 
 :   	  <   
 
 /   
  9   
  @               D          6     +     -    
 .     1      2     B     E    	 0      2   	                �  ]  �           �   n  
 , b   " 5#U Mn  
q  M $ , M  q  T p  C 'o  o  o  Fo  C 
" p  4 o  
" p  4 o  F n  o0 Co  o   	 �&��!S�Ȓ�����S&�*l�p�jwN`�x]   Y   M   H   >   2   .   )   $        :  @   b   [x 8 8 3 R#" MM%" p0 �
M5" p0 �ME#F Mr0  F p0 4 Mr0  p\ ��          c   F   n   
�k��#42!A 9$.�3! F�
 F n  MF n  	�v   " #A M n   
 q    M , M q   p  � 'F n   F n  p] �        G  $   b   8  ; #" Mr0  "  TA  p0  TA n   TA n        T     b   8  = "#" M" p0 dMr0   BG H  � 6ZZ 8            	                                         
                          $change <init> I J L LI LLL LLLL Landroid/content/Context; Landroid/content/Intent; Landroid/os/Bundle; Landroid/os/CountDownTimer; 0Lcom/android/tools/ir/runtime/IncrementalChange; 5Lcom/android/tools/ir/runtime/InstantReloadException; 0Lcom/safisoft/fakelocation_duckgps/MapsActivity; 5Lcom/safisoft/fakelocation_duckgps/OpeningActivity$1; 3Lcom/safisoft/fakelocation_duckgps/OpeningActivity; #Ldalvik/annotation/EnclosingMethod; Ldalvik/annotation/InnerClass; Ljava/lang/Boolean; Ljava/lang/Class; Ljava/lang/Integer; Ljava/lang/Long; Ljava/lang/Number; Ljava/lang/Object; Ljava/lang/String; OpeningActivity.java 8String switch could not find '%s' with hashcode %s in %s V VI VJ VJJ VL VLJJ VLL VZ Z ZL [Ljava/lang/Object; access$dispatch access$super accessFlags cancel clone 3com/safisoft/fakelocation_duckgps/OpeningActivity$1 equals finalize finish format getClass hashCode �init$args.([Lcom/safisoft/fakelocation_duckgps/OpeningActivity$1;Lcom/safisoft/fakelocation_duckgps/OpeningActivity;JJ[Ljava/lang/Object;)Ljava/lang/Object; �init$body.(Lcom/safisoft/fakelocation_duckgps/OpeningActivity$1;Lcom/safisoft/fakelocation_duckgps/OpeningActivity;JJ[Ljava/lang/Object;)V intent 	longValue millisUntilFinished name onCreate onFinish onFinish.()V onTick onTick.(J)V serialVersionUID start startActivity this$0 toString value valueOf wait x0 x1 C)8 �!� ���
����!�	���m��~�poR          O  U  �                               H   p         �        �        �                �                :       \     H   �        O         ]        �       �        �        �                                                                                                                                                                                                                                                                                                                                                                                                  ion conn;
        try {
            if ((conn = getValidatedMasterConnection()) != null) {
                conn.ping();
            }
        } catch (SQLException e) {
            if (isMasterConnection()) {
                throw e;
            }
        }
        try {
            if ((conn = getValidatedSlavesConnection()) != null) {
                conn.ping();
            }
        } catch (SQLException e) {
            if (!isMasterConnection()) {
                throw e;
            }
        }
    }

    @Override
    public synchronized void changeUser(String userName, String newPassword) throws SQLException {
        Connection conn;
        if ((conn = getValidatedMasterConnection()) != null) {
            conn.changeUser(userName, newPassword);
        }
        if ((conn = getValidatedSlavesConnection()) != null) {
            conn.changeUser(userName, newPassword);
        }
    }

    @Override
    public synchronized void setStatementComment(String comment) {
        Connection conn;
        if ((conn = getValidatedMasterConnection()) != null) {
            conn.setStatementComment(comment);
        }
        if ((conn = getValidatedSlavesConnection()) != null) {
            conn.setStatementComment(comment);
        }
    }

    @Override
    public boolean hasSameProperties(Connection c) {
        Connection connM = getValidatedMasterConnection();
        Connection connS = getValidatedSlavesConnection();
        if (connM == null && connS == null) {
            return false;
        }
        return (connM == null || connM.hasSameProperties(c)) && (connS == null || connS.hasSameProperties(c));
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();
        Connection conn;
        if ((conn = getValidatedMasterConnection()) != null) {
            props.putAll(conn.getProperties());
        }
        if ((conn = getValidatedSlavesConnection()) != null) {
            props.putAll(conn.getProperties());
        }

        return props;
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        getThisAsProxy().doAbort(executor);
    }

    @Override
    public void abortInternal() throws SQLException {
        getThisAsProxy().doAbortInternal();
    }

    @Override
    public boolean getAllowMasterDownConnections() {
        return getThisAsProxy().allowMasterDownConnections;
    }

    @Override
    public void setAllowMasterDownConnections(boolean connectIfMasterDown) {
        getThisAsProxy().allowMasterDownConnections = connectIfMasterDown;
    }

    @Override
    public boolean getReplicationEnableJMX() {
        return getThisAsProxy().enableJMX;
    }

    @Override
    public void setReplicationEnableJMX(boolean replicationEnableJMX) {
        getThisAsProxy().enableJMX = replicationEnableJMX;
    }

    @Override
    public void setProxy(MySQLConnection proxy) {
        getThisAsProxy().setProxy(proxy);
    }
}
