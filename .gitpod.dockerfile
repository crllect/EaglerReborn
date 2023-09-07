FROM gitpod/workspace-full-vnc

RUN sudo apt-get update
RUN sudo apt-get install ffmpeg -y
RUN bash YoinkAssets.sh
RUN wget https://gist.githubusercontent.com/OtterCodes101/8f97eece5624c708f96540b5214c15f8/raw/e998a2002ae638bb2fb68c9cb532339fee1b538f/buildtools_config.json
RUN bash build_init.sh
RUN bash build_make_workspace.sh