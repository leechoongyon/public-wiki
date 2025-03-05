# Authorization Bearer

### 요약
- Bearer 토큰은 현대 웹 인증에서 널리 사용되는 표준 방식
- OAuth 2.0 및 API 보안 사용

### Bearer 토큰 개요
- Bearer 토큰은 HTTP Authorization 헤더에 포함되어 클라이언트가 서버에  전달
```text
Authorization: Bearer <토큰>
```
- JWT(JSON Web Token)와 함께 자주 사용되며, stateless 아키텍처에서 효율적인 인증 가능

### Bearer 토큰 장단점
- Bearer 토큰은 간단하고 확장 가능한 인증 방식을 제공
- 토큰 탈취 시 보안 위험이 있어, 대책 필요
    - HTTPS 사용, 짧은 만료 시간 설정, 토큰 범위 제한 등의 보안 조치

### 참고
- https://velog.io/@oneook/%EC%99%9C-Authorization-Bearer%EC%9D%B8%EA%B0%80%EC%9A%94 참고
