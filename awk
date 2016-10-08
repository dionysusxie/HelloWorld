find . -name "app-10.200.28.45-09-29-2016-1*" | xargs awk -F '\t' '{print $6,$11}'  | grep And

