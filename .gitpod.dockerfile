FROM gitpod/workspace-full-vnc

RUN sudo apt-get update
RUN sudo apt-get install ffmpeg -y