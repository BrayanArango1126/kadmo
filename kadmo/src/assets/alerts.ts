import Swal, { SweetAlertIcon } from 'sweetalert2';

export const redirectAlert = async (icon: SweetAlertIcon, title: string, route: string) => {
  await Swal.fire({
    icon: icon,
    title: title,
  }).then(() => {
    window.location.href = `/${route}`;
  });
};

export const infoAlert = async (icon: SweetAlertIcon, title: string, text:string) => {
  await Swal.fire({
    icon: icon,
    title: title,
    text: text
  })
};

export const redirectActivedAlert = async (icon: SweetAlertIcon, title: string, route: string, redirect:string) => {
  await Swal.fire({
    icon: icon,
    title: title,
  }).then(() => {
    window.location.href = `/${route}?redirectUrl=${encodeURIComponent(redirect)}`;
  });
};