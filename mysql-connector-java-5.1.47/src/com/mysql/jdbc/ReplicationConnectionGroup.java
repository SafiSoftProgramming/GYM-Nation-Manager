dex
035 ��"�����V���	��k�BѸҔ  p   xV4        �  q   p      4     P  d   \     |     �  �  �  �  �  �    +  O  o  �  �  �  �  �    <  Z  }  �  �  �    ?  `  u  �  �  �  �  	  )	  ;	  N	  c	  u	  �	  �	  �	  �	  �	  
  '
  B
  l
  �
  �
  �
    -  C  Z  a  n  |  �  �  �    7  c  �  �  �    =  \  �  �  �  �  �    3  S  t  �  �  �  �  �  �    $  7  J  ]  p  v  �  �  �    #  :  R  v  �  �  �  �    9  `  �  �  �  �    3  V  z  �  �  �  �                                    	      
                                                                                                                                           !      "      $      %      &      '      (      )      *      +      ,      -      .      /      1      2      3      4      5      6      7      8      9      :      ;      <      =      >      ?      @      A      B      C      D      E      F      G      H      I      J      K      L      M      N      O      P      Q      R      S      U      V      W      X      Y      Z      [      \      ]      ^      _      `      a      b      c      d      e      f      g      h      i      j      k      l      m      n      o                                 �  �  �       �     p    �     <init> I +Lcom/safisoft/fakelocation_duckgps/R$color; %Lcom/safisoft/fakelocation_duckgps/R; "Ldalvik/annotation/EnclosingClass; Ldalvik/annotation/InnerClass; Ljava/lang/Object; R.java V 0abc_background_cache_hint_selector_material_dark 1abc_background_cache_hint_selector_material_light (abc_btn_colored_borderless_text_material abc_btn_colored_text_material abc_color_highlight_material !abc_hint_foreground_material_dark "abc_hint_foreground_material_light !abc_input_method_navigation_guard +abc_primary_text_disable_only_material_dark ,abc_primary_text_disable_only_material_light abc_primary_text_material_dark abc_primary_text_material_light abc_search_url_text abc_search_url_text_normal abc_search_url_text_pressed abc_search_url_text_selected  abc_secondary_text_material_dark !abc_secondary_text_material_light abc_tint_btn_checkable abc_tint_default abc_tint_edittext abc_tint_seek_thumb abc_tint_spinner abc_tint_switch_track accent_material_dark accent_material_light accessFlags !background_floating_material_dark "background_floating_material_light background_material_dark background_material_light (bright_foreground_disabled_material_dark )bright_foreground_disabled_material_light 'bright_foreground_inverse_material_dark (bright_foreground_inverse_material_light bright_foreground_material_dark  bright_foreground_material_light button_material_dark button_material_light color colorAccent colorPrimary colorPrimaryDark "common_google_signin_btn_text_dark *common_google_signin_btn_text_dark_default +common_google_signin_btn_text_dark_disabled *common_google_signin_btn_text_dark_focused *common_google_signin_btn_text_dark_pressed #common_google_signin_btn_text_light +common_google_signin_btn_text_light_default ,common_google_signin_btn_text_light_disabled +common_google_signin_btn_text_light_focused +common_google_signin_btn_text_light_pressed common_google_signin_btn_tint %dim_foreground_disabled_material_dark &dim_foreground_disabled_material_light dim_foreground_material_dark dim_foreground_material_light error_color_material foreground_material_dark foreground_material_light highlighted_text_material_dark highlighted_text_material_light material_blue_grey_800 material_blue_grey_900 material_blue_grey_950 material_deep_teal_200 material_deep_teal_500 material_grey_100 material_grey_300 material_grey_50 material_grey_600 material_grey_800 material_grey_850 material_grey_900 name  notification_action_color_filter notification_icon_bg_color 4notification_material_background_media_default_color primary_dark_material_dark primary_dark_material_light primary_material_dark primary_material_light "primary_text_default_material_dark #primary_text_default_material_light #primary_text_disabled_material_dark $primary_text_disabled_material_light ripple_material_dark ripple_material_light $secondary_text_default_material_dark %secondary_text_default_material_light %secondary_text_disabled_material_dark &secondary_text_disabled_material_light #switch_thumb_disabled_material_dark $switch_thumb_disabled_material_light switch_thumb_material_dark switch_thumb_material_light !switch_thumb_normal_material_dark "switch_thumb_normal_material_light tooltip_background_dark tooltip_background_light transYallColor transYallColorDark value p#T0d    ���dd  d d d d d d d d d	 d
 d d d d d d d d d d d d d d d d d d d d d d  d! d" d# d$ d% d& d' d( d) d* d+ d, d- d. d/ d0 d1 d2 d3 d4 d5 d6 d7 d8 d9 d: d; d< d= d> d? d@ dA dB dC dD dE dF dG dH dI dJ dK dL dM dN dO dP dQ dR dS dT dU dV dW dX dY dZ d[ d\ d] d^ d_ d` da db dc          �  �  �                               q   p         4        P     d   \        |        �        �        �     q   �        �         �        �       �        �        �                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  return matched;
    }

    public int getConnectionCountWithHostAsMaster(String hostPortPair) {
        int matched = 0;

        for (ReplicationConnection c : this.replicationConnections.values()) {
            if (c.isHostMaster(hostPortPair)) {
                matched++;
            }
        }
        return matched;
    }

    public long getNumberOfSlavesAdded() {
        return this.slavesAdded;
    }

    public long getNumberOfSlavesRemoved() {
        return this.slavesRemoved;
    }

    public long getNumberOfSlavePromotions() {
        return this.slavesPromoted;
    }

    public long getTotalConnectionCount() {
        return this.connections;
    }

    public long getActiveConnectionCount() {
        return this.activeConnections;
    }

    @Override
    public String toString() {
        return "ReplicationConnectionGroup[groupName=" + this.groupName + ",masterHostList=" + this.masterHostList + ",slaveHostList=" + this.slaveHostList
                + "]";
    }
}
