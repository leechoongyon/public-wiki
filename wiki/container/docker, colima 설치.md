# docker 설치
- brew install docker

# colima 실행 시 에러
- 아래 에러 발생
```FATA[0000] limactl is running under rosetta, please reinstall lima with native arch FATA[0001] lima compatibility error: error checking Lima version: exit status 1```
- https://stackoverflow.com/questions/78169611/how-to-solve-limactl-is-running-under-rosetta-please-reinstall-lima-with-nativ 참고해서해결

# colima 설치
- https://www.dae.mn/blog/docker-in-mac-m1/m2-colima 보고 해결
- docker context use colima (colima 로 endpoint 변경)

# colima 명령어
- colima status
- colima start --cpu 4 --memory 8 --disk 50 --arch x86_64
- colima stop

