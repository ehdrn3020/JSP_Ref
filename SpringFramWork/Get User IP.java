/* 유저가 허용 IP에서 접근하는지 확인 */

@RequestMapping(value = "login_success.do", method = RequestMethod.GET)
	public ModelAndView loginSuccess(HttpSession session, ModelMap model) throws Exception {
		LOGGER.info("IP CHECK !");
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

  String ip = req.getHeader("X-FORWARDED-FOR");
  if (ip == null)
      ip = req.getRemoteAddr();
  LOGGER.info("USER IP IS "+ip);
    
  return ....    
}




###가져오는 IP주소가 IPv6일때###

특정os에서 발생하는 문제이고(windows7) 톰캣을 사용했을때 해결 방법이다
request.getRemoteAddr()로 ip를 가져올때 0:0:0:0:0:0:0:1라고 나온다면 
이것은 인터넷 주소체계 ipv4, ipv6의 루프백 주소 차이이므로 비정상은 아니다
ipv4의 루프백 주소는 127.0.0.1
ipv6의 루프백 주소는 0:0:0:0:0:0:0:1
위와 같고 windows7은 기본적으로 ipv6 type으로 ip를 리턴하므로 ipv4형식으로 ip를 보고 싶다면 was 기동시 vm argument를 ipv4 type으로 주면 된다

(1) eclipse에서 tomcat을 실행할경우 
    메뉴의 Run->Run Configurations-> Arguments 탭-> -Djava.net.preferIPv4Stack=true 추가
출처: http://kdarkdev.tistory.com/3 [kdarkdev]

