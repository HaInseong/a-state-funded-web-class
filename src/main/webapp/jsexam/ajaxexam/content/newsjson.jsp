<%@ page language="java" contentType="application/json; charset=UTF-8"%>
<% String news[] = { "우주항공 발달한 경남도-일본 아이치현, 교류협력 확대한다",
		"팟캐스트 앱 누가 써?…구글 팟캐스트, 2024년 폐쇄",
		"창립 25주년 구글…'AI, 구글 사명 완수할 수 있는 가장 중요한 방법'",
  	    "‘인기 대폭발’ 대전 공영자전거 ‘타슈’… 확 늘어나고, 계속 진화한다",
		"메타 Z세대 위한 AI챗봇 공개 임박...“다양한 캐릭터로 친구처럼”",
		"국내 웹소설 시장 1兆 돌파…‘네이버·카카오·리디’ 90% 점유",
		"올 연휴에도 어김없는 스미싱 공격…'모르는 링크 클릭 마세요'"}; %>
<% response.setHeader("Cache-Control", "no-cache"); %> 응답된 내용은 캐시하지 말아라
<% int num = (int)(Math.random() * 7);%>
{ 
	"news" : "<%= news[num] %>"
}