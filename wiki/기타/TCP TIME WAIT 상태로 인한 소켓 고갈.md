# TCP TIME WAIT 상태로 인한 소켓 고갈

### 4 way handshake
- tcp 통신을 종료하기 위한 flow
- client, server 모두 Active Closer (통신 연결을 끊을려고 하는 주체) 가 될 수 있음

### TIME WAIT
- 보통 2~3분 유지
- 지연된 패킷이 도착할 경우를 대비 (무결성 문제 방지)
- TIME_WAIT 기간 동안 로컬 포트를 점유하여 즉시 재사용되는 것을 방지
- 마지막 ACK 패킷 유실 대비
    - 연결 종료 과정의 마지막 단계에서 Active Closer가 Passive Closer에게 보내는 ACK가 유실될 수 있음
    - 이 경우, Passive Closer는 LAST_ACK 상태에 머물게 되며, 일정 시간 후 FIN 패킷을 재전송

### TIME WAIT 로 인한 소켓 고갈
- TCP 자체가 잦은 연결 수립/끊음이 발생하면 TIME_WAIT 가 많이 발생할 수 있음 (대량의 트래픽)

### TIME WAIT 로 인한 소켓 고갈 해결방안
- 해결방안으로 커넥션 풀을 사용하여 한 번 맺어 놓은 TCP 를 재사용하도록 구현
- 커넥션 풀을 사용한다는건 동일한 요청에 대해 처리한다는 것이고, 만약 동일한 요청이 아니라면 로드 밸런싱, 서버 스케일 아웃, 비동기 처리 등을 고민해봐야 함
